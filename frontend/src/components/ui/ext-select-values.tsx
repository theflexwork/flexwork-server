import {
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import React from "react";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { UiAttributes } from "@/types/ui-components";

interface ValuesSelectProps {
  form: any;
  fieldName: string;
  values: Array<string>;
  label: string;
  placeholder: string;
}

const ValuesSelect = ({
  form,
  fieldName,
  label,
  placeholder,
  values,
  required,
}: ValuesSelectProps & UiAttributes) => {
  return (
    <FormField
      control={form.control}
      name={fieldName}
      render={({ field }) => (
        <FormItem className="flex flex-col">
          <FormLabel>
            {label}
            {required && <span className="text-destructive"> *</span>}
          </FormLabel>
          <Select
            onValueChange={field.onChange}
            defaultValue={field.value}
            {...field}
          >
            <FormControl>
              <SelectTrigger>
                <SelectValue placeholder={placeholder} />
              </SelectTrigger>
            </FormControl>
            <SelectContent>
              {values?.map((value) => (
                <SelectItem key={value} value={value}>
                  {value}
                </SelectItem>
              ))}
            </SelectContent>
          </Select>
          <FormMessage />
        </FormItem>
      )}
    />
  );
};

export default ValuesSelect;