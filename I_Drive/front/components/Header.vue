<template>
  <header class="bg-secondary text-white flex items-center justify-between p-4">
      <font-awesome-icon :icon="['fab', 'google-drive']" size="2xl" class="color-primary" />
      <UNavigationMenu content-orientation="vertical" :items="items" />
  </header>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import type { NavigationMenuItem } from '@nuxt/ui'
// TODO : Si l'utilisateur est connecter mettre le label Se déconnecter avec logo pajamas:unapproval
const items = ref<NavigationMenuItem[]>([
  {
    label: 'Authentification',
    icon: 'codicon:account',
    active:true,
    children: [
      {
        // TO DO : ajouter variable ternaire sur les 3 champ selon le statut de connexion
        // On peut ajouter un on click au lieu du to ? ou mettre la deconnexion
        label: 'Se connecter',
        icon: 'pajamas:approval',
        to: '/login'
      },
      {
        label: 'S\'inscrire',
        icon: 'pajamas:assignee',
        to:'/inscription'
      }
    ]
  },
])
</script>
