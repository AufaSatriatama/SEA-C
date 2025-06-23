<template>
  <Carousel v-bind="carouselConfig">
    <Slide v-for="(testimonial, index) in testimonials" :key="index" class="divRow">
        <div class="carousel__item">
            <TestimonialCard :testimonial="testimonial" />
        </div>
    </Slide>

    <template #addons>
      <Navigation />
      <Pagination />
    </template>
  </Carousel>
</template>

    

<style scoped>


.carousel__item {
  width: 100%;
  height: 300px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0;
  padding: 0;
}

    .divRow{
        display: flex;
        flex-direction: row;
        width: 100%;
        height: 300px;
        gap: 1rem;
        padding: 1rem;
        margin: 0rem;
        background-color: rgb(255, 255, 255);
    }
</style>

<script setup>

    import 'vue3-carousel/carousel.css'
    import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'

    import { reactive, ref } from 'vue';
    import TestimonialCard from './TestimonialCard.vue';

const carouselConfig = {
  itemsToShow: 1,
  wrapAround: true,
  snapAlign: 'center',
  autoplay: 3000,
  pauseAutoplayOnHover: true,
  transition: 600,
  mouseDrag: false, // Disable mouse drag to prevent shaking
  breakpoints: {
    768: {
      itemsToShow: 1
    }
  }
};

   const testimonials = ref([
       { name: 'John Doe', message: 'Great service!', rating: 5 },
       { name: 'Jane Smith', message: 'Loved the meal plans!', rating: 4 },
       { name: 'Alice Johnson', message: 'Very helpful team.', rating: 5 }
   ]);



</script>