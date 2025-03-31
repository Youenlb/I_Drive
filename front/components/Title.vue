<script setup lang="ts">
defineProps({
  content: {
    type: String,
    required: true
  },
})
</script>
<template>
  <h1 :class="`text-5xl color-secondary text-center m-4`">
    {{ content }}
  </h1>
</template>