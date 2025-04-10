<script setup lang="ts">


import type { ItemInfo } from "@/services/FileService"
import type { DropdownMenuItem } from '@nuxt/ui'
import ListItems from "@/components/list/Items.vue"
import { ref } from "vue";

// TODO : Loader
// Récupération des données du dossier actuel de l'utilisateur
// TODO : Enregistrement dans le cache
// TODO : Fin loader



// TODO : Supprimer ces données de test quand le service sera fait
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


// TODO :
  // - Ajouter le use pour charger le contenu du dossier que l'on consulte
  // - Faire les appels au folder service pour charger dans folders et files ce que retourne le FolderService de getContent
  // - Gérer l'affichage de la liste des dossiers s'il y a des dossiers
  // - Gérer l'affichage de la liste des fichiers s'il y a des fichier
  // - Gérer l'ajout d'un dossier (appel au FolderService)
  // - Gérer l'ajout d'un fichier (appel au FileService)
  // - Gérer l'importation d'un dossier entier avec l'ensemble de ces infos (utiliser une biliothèque pour recup les infos souhaitée en JSON ?)
  // - Gérer le téléchargement du fichier
  // - Gérer le téléchargement d'un dossier entier
  // - Gérer la suppression d'un fichier
  // - Gérer la suppression d'un dossier
  // - Gestion de l'authentification
    //- Changement de l’état du menu à faire selon si l’utilisateur est connecter ou non
      //- Si connecter indiquer le nom de l’utilisateur
      //- Si connecter Changer le menu avec Se déconnecter au lieu de Se connecter
    //- Regarder l’ancien projet pour savoir ce qu’il faut faire côté front pour la gestion d’authentification utilisation de certaines variables ?
</script>
<template>
  <div> 
    <DropDownButton icon="codex:plus" label="Nouveau" :items="optionsForDropDownActionMenu" />
    <ListItems title="Mes dossiers" :datas="folders" :options="optionsForDropDownMenuOfListItem"/>
    <ListItems title="Mes fichiers" :datas="files" :options="optionsForDropDownMenuOfListItem"/>
  </div>
</template>