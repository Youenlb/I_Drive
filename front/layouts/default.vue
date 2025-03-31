<script setup lang="ts">
import Header from "@/components/Header.vue";
</script>

<template>
  <div class="flex flex-col h-screen">  
  <Header class="sticky top-0 w-full z-10" />
  <main class="flex-grow bg-secondary">
      <slot />
    </main>
  </div>
</template>