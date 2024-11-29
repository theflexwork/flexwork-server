package io.flexwork.modules.teams.repository;

import io.flexwork.modules.teams.domain.WorkflowState;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowStateRepository extends JpaRepository<WorkflowState, Long> {

    @Query(
            "SELECT ws FROM WorkflowState ws WHERE ws.workflow.id = :workflowId AND ws.isInitial = true")
    WorkflowState findInitialStateByWorkflowId(@Param("workflowId") Long workflowId);

    @Query(
            """
    SELECT ws
    FROM WorkflowState ws
    WHERE ws.workflow.id = :workflowId
      AND ws.stateName != :excludedStateName
""")
    List<WorkflowState> findStatesByWorkflowExcludingState(
            @Param("workflowId") Long workflowId,
            @Param("excludedStateName") String excludedStateName);

    List<WorkflowState> findByWorkflowId(Long workflowId);
}
