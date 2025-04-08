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

const optionsForDropDownActionMenu = ref<DropdownMenuItem[]>(
[
  { label: 'Nouveau dossier', icon: 'material-symbols:create-new-folder-outline' },
  { label: 'Importer un dossier', icon: 'material-symbols:drive-folder-upload-outline-rounded' },
  { label: 'Importer un fichier', icon: 'material-symbols:file-save-outline-sharp' }
])

const optionsForDropDownMenuOfListItem = ref<DropdownMenuItem[]>([
  {
    label: 'Télécharger',
    icon: 'material-symbols:download'
  },
  {
    label: 'Supprimer',
    icon: 'codex:cross'
  }
])
</script>
<template>
  <div> 
    <DropDownButton icon="codex:plus" label="Nouveau" :items="optionsForDropDownActionMenu" />
    <ListItems title="Mes dossiers" :datas="folders" :options="optionsForDropDownMenuOfListItem"/>
    <ListItems title="Mes fichiers" :datas="files" :options="optionsForDropDownMenuOfListItem"/>
  </div>
</template>