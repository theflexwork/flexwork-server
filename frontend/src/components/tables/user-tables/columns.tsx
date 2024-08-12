'use client';
import { Checkbox } from '@/components/ui/checkbox';
import { User } from '@/types/commons';
import { ColumnDef } from '@tanstack/react-table';
import { CellAction } from './cell-action';

export const columns: ColumnDef<User>[] = [
    {
        id: 'select',
        header: ({ table }) => (
            <Checkbox
                checked={table.getIsAllPageRowsSelected()}
                onCheckedChange={(value) => table.toggleAllPageRowsSelected(!!value)}
                aria-label="Select all"
            />
        ),
        cell: ({ row }) => (
            <Checkbox
                checked={row.getIsSelected()}
                onCheckedChange={(value) => row.toggleSelected(!!value)}
                aria-label="Select row"
            />
        ),
        enableSorting: false,
        enableHiding: false
    },
    {
        accessorKey: 'first_name',
        header: 'Name'
    },
    {
        accessorKey: 'email',
        header: 'Email'
    },
    {
        accessorKey: 'authorities',
        header: 'Authorities'
    },
    {
        id: 'actions',
        cell: ({ row }) => <CellAction data={row.original} />
    }
];