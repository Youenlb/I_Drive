<script setup lang="ts">
import type { ItemInfo } from "@/services/FileService"
defineProps<{
  data: ItemInfo
}>();
</script>

<template>
  <UCard class="cursor-pointer hover:bg-gray-800 transition">
    <div class="flex items-center space-x-3">
      <UIcon :name="data.icon" class="w-6 h-6" />
      <span class="font-medium">{{ data.name }}</span>
      <!--TO DO : ajouter bouton affichant actions-->
    </div>
  </UCard>
</template>