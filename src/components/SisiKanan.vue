<template>
  <div class="sisi-kanan">
    <p v-if="text">{{ text }}</p>
    <p v-else>Hover item di kiri dulu</p>
  </div>
</template>

<script setup>
defineProps(['text'])
</script>

<style>
.sisi-kanan{
  width: 60%;
  background-color: #402f2f;
  padding: 1rem;
}
</style>
