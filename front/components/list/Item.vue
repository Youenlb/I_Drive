<script setup lang="ts">
import type { ItemInfo } from "@/services/FileService"
defineProps<{
  data: ItemInfo
}>();
const items = ref<DropdownMenuItem[]>([
  {
    label: 'Supprimer',
    icon: 'codex:cross'
  },
])
</script>

<template>
  <UCard class="cursor-pointer hover:bg-gray-800 transition">
    <div class="flex items-center justify-between">
      <div class="h-full flex items-center space-x-3">
        <UIcon :name="data.icon" class="w-6 h-6" />
        <span class="font-medium">{{ data.name }}</span>
      </div>
      <UDropdownMenu arrow :items="items" :ui="{ content: 'w-48'}">
        <UButton icon="codex:etc-vertical" color="neutral" variant="outline" />
      </UDropdownMenu>
    </div>
  </UCard>
</template>