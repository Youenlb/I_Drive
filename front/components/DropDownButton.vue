<script setup lang="ts">
import type { DropdownMenuItem } from '@nuxt/ui'
defineProps<{
  icon?: string,
  label?: string,
  options: DropdownMenuItem[]

}>();
/** TODO : Faire en sorte d'afficher le dropdownMenu en cas de clic droit */
</script>

<template>
    <UDropdownMenu arrow :items="options" :ui="{ content: 'w-48'}">
        <UButton :icon="icon" :label="label" color="neutral" variant="outline" />
    </UDropdownMenu>
</template>