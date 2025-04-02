<script setup lang="ts">
defineProps({
  content: {
    type: String,
    required: true
  },
})
</script>
<template>
  <h1 :class="`text-4xl text-center m-4`">
    {{ content }}
  </h1>
</template>