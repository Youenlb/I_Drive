<script setup lang="ts">
import type { DropdownMenuItem } from '@nuxt/ui'
import type { ItemInfo } from "@/services/FileService"
defineProps<{
  title: string;
  datas: ItemInfo[];
  options: DropdownMenuItem[];
}>();
// TODO : Refactor sûrement avec un slot pour éviter des passer plusieurs fois options en props ? 
</script>

<template>
    <div class="m-4">
        <h1 class="text-xl color-white font-semibold mb-4"> {{ title }}</h1>
        <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 gap-4">
            <div v-for="data in datas" :key="data.name">
                <ListItem :data="data" :options="options"/>
            </div>
        </div>
    </div>
</template>