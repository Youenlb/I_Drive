<script setup lang="ts">
import type { ItemInfo } from "@/services/FileService"
import ListItems from "@/components/list/Items.vue"
const folders:ItemInfo[] = [
  { name: "Documents", icon: "i-heroicons-folder"},
  { name: "Images", icon: "i-heroicons-folder"},
  { name: "Vidéos", icon: "i-heroicons-folder"},
  { name: "Musique", icon: "i-heroicons-folder"},
  { name: "Documents", icon: "i-heroicons-folder"},
  { name: "Images", icon: "i-heroicons-folder"},
  { name: "Vidéos", icon: "i-heroicons-folder"},
  { name: "Musique", icon: "i-heroicons-folder"},
];

const files:ItemInfo[] = [
  { name: "diagramme", icon: "i-heroicons-folder"},
  { name: "photo_famille_2024", icon: "i-heroicons-folder"},
  { name: "code1", icon: "i-heroicons-folder"},
  { name: "code2", icon: "i-heroicons-folder"},
  { name: "code3", icon: "i-heroicons-folder"},
  { name: "code4", icon: "i-heroicons-folder"},
  { name: "code5", icon: "i-heroicons-folder"},
  { name: "code6", icon: "i-heroicons-folder"},
]
</script>
<template>
  <div> 
    <ListItems title="Mes dossiers" :datas="folders"/>
    <ListItems title="Mes fichiers" :datas="files"/>
  </div>
</template>