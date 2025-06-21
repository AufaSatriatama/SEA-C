<template>
  <div class="sisi-kiri">
    <div
      v-for="(item, index) in items"
      :key="index"
      class="item"
      @mouseover="$emit('hover-item', index)"
      @mouseleave="$emit('hover-item', null)"
    >
      {{ item }}
    </div>
  </div>
</template>

<script setup>
defineProps(['items'])
defineEmits(['hover-item'])
</script>

<style>
.item {
  color: black;
  font-family: poppins, sans-serif;
}

.sisi-kiri {
  width: 60vw;
  height: 25vh;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  background-color: rgb(255, 255, 255);
}
</style>
