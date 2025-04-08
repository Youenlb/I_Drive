<script setup lang="ts">
import type { ItemInfo } from "@/services/FileService"
import type { DropdownMenuItem } from '@nuxt/ui'
defineProps<{
  data: ItemInfo
  options: DropdownMenuItem[]
}>();
</script>

<template>
  <UCard class="cursor-pointer hover:bg-gray-800 transition">
    <div class="flex items-center justify-between">
      <div class="h-full flex items-center space-x-3">
        <UIcon :name="data.icon" class="w-6 h-6" />
        <span class="font-medium">{{ data.name }}</span>
      </div>
      <!-- TODO : Ajouter v-if si options passé-->
      <DropDownButton icon="codex:etc-vertical" :options="options" />
    </div>
  </UCard>
</template>