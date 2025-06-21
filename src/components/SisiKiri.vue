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
.sisi-kiri {
  width: 40%;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  background-color: aqua;
}
</style>
