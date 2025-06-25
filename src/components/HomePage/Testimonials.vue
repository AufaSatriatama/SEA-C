<template>


    
  <Carousel v-bind="carouselConfig" class="carousel-wrapper"> 
    <Slide v-for="(testimonial, index) in testimonials" :key="index">
        <div class="carousel__item">
            <div class="fixed-card">
                <TestimonialCard :testimonial="testimonial"/>
            </div>
        </div>
    </Slide>
    

    <template #addons>
      <Navigation />
      <Pagination />
    </template>
  </Carousel>
  
</template>

    

<style scoped>

.carousel__slide {
  background-color: #eee;

}

.carousel__item {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 300px;
  background-color: white;
}

.fixed-card {
  width: 250px;
  height: 100%;
  max-height: 100%;
  background: white;
  padding: 1rem;
  border-radius: 12px;
  box-sizing: border-box;
  transition: transform 0.3s ease;
}


.carousel-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  max-width: 900px;
  margin: auto;
  background: white;
  padding: 2rem 0;
}

.carousel__item {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1rem;
  box-sizing: border-box;
  background-color: white;
}


.color2{
    background-color: aqua;
    width: 100%;
}

.color {
  background-color: rgb(255, 255, 255); /* Light gray background for the carousel items */
 /* Rounded corners for the items */
 max-width: 30vw;
 display: flex;
 flex-direction: row;
 gap: 10rem;

}



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
  autoplay: 0,
  pauseAutoplayOnHover: true,
  transition: 600,
  mouseDrag: false, // Disable mouse drag to prevent shaking

};

   const testimonials =[
       { name: 'John Doe', message: 'Great service!', rating: 5 },
       { name: 'John Doe', message: 'Great service!', rating: 5 },
       { name: 'John Doe', message: 'Great service!', rating: 5 },
   ];



</script>