"use client";

import React from "react";
import { useFormStatus } from "react-dom";

import { Button } from "@/components/ui/button";
import {
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { UiAttributes } from "@/types/ui-components";

interface ExtInputProps {
  form: any;
  fieldName: string;
  label: string;
  placeholder?: string;
}

export interface FormProps<Entity> {
  initialData: Entity | undefined;
}

export const ExtInputField = ({
  form,
  fieldName,
  label,
  placeholder,
  required,
}: ExtInputProps & UiAttributes) => {
  return (
    <FormField
      control={form.control}
      name={fieldName}
      render={({ field }) => (
        <FormItem>
          <FormLabel>
            {label}
            {required && <span className="text-destructive"> *</span>}
          </FormLabel>
          <FormControl>
            <Input placeholder={placeholder} {...field} />
          </FormControl>
          <FormMessage />
        </FormItem>
      )}
    />
  );
};

export const ExtTextAreaField = ({
  form,
  fieldName,
  label,
  placeholder,
  required,
}: ExtInputProps & UiAttributes) => {
  return (
    <FormField
      control={form.control}
      name={fieldName}
      render={({ field }) => (
        <FormItem>
          <FormLabel>
            {label}
            {required && <span className="text-destructive"> *</span>}
          </FormLabel>
          <FormControl>
            <Textarea placeholder={placeholder} {...field} />
          </FormControl>
          <FormMessage />
        </FormItem>
      )}
    />
  );
};

interface SubmitButtonProps {
  label: string;
  labelWhileLoading: string;
}
export const SubmitButton = ({
  label,
  labelWhileLoading,
}: SubmitButtonProps) => {
  const { pending } = useFormStatus();

  return (
    <Button type="submit" disabled={pending}>
      {!pending ? label : labelWhileLoading}
    </Button>
  );
};
