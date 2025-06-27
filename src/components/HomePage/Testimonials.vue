<template>

  <!--Render manual-->


  <div>
    <Carousel 
      class="carousel-wrapper"> 
      <!--Sementara pakai data dummy-->
      <!--Nanti pakai testimonials.value-->
      <!--Perhatikan yang testimonialsDummy gak pakai ref()-->
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
  </div>

  <div>
    <button @click="deleteLast">Delete Last Element</button>
    <button @click="addTestimonial">Add Testi</button>
  </div>





  <!--Untuk test
  <div>
    <button @click="addTestimonial">Fetch Data</button>
  </div>

  <div>
    <button @click="deleteInvalid">Hapus yang null</button>
  </div>

-->
  
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

  import { ref, onMounted, onUnmounted } from 'vue'
  import axios from 'axios'


  const testimonialsDummy = [
    { name: 'John Doe', message: 'Great service!', rating: 5 },
    { name: 'John Doe', message: 'Great service!', rating: 5 },
    { name: 'John Doe', message: 'Great service!', rating: 5 },
   ];

  const testimonials = [
    { name: 'John Doe', message: 'Great service!', rating: 5 },
   ];

  const testimonialsDb = ref([]);

  //Testing untuk input data ke database

  const name = ref('test');
  const message = ref('test');
  const rating = ref(5);

  let jumlahTestimonial = ref(1);



  const addTestimonial = async () => {
    try {
      const newTestimonial = {
        name: name.value,
        message: message.value,
        rating: rating.value
      }

      if (!newTestimonial.name || !newTestimonial.message || newTestimonial.rating === null || newTestimonial.rating === undefined) {
        console.error('Semua field harus diisi!')
        return
      }
      await axios.post('http://localhost:8080/Testimonials', newTestimonial, {withCredentials: true});


      await fetchTestimonials() // Refresh langsung setelah submit
      console.log('UPDATE testimonials:', testimonials.value)
    } catch (err) {
      console.error('Gagal kirim data ke backend:', err)
    }
  }

  // Auto-refresh tiap 5 detik
  let intervalId
  onMounted(() => {
    fetchTestimonials()
    intervalId = setInterval(fetchTestimonials, 5000) // <-- Real-time effect
  })

  // Hentikan polling saat komponen dihancurkan
  onUnmounted(() => {
    clearInterval(intervalId)
  })

// Ambil data dari backend saat pertama kali halaman dibuka
  const fetchTestimonials = async () => {
    try {
      const res = await axios.get('http://localhost:8080/Testimonials')
      console.log('DATA DARI BACKEND:', res.data)

      // Kosongkan array lalu isi ulang

      if (jumlahTestimonial.value != res.data.length) {
        console.log('length asli:', testimonials.length)
        console.log('length baru:', res.data.length)
        testimonials.value = [] // Kosongkan array testimonials

        
          testimonials.push(res.data[res.data.length - 1])
        

      }

      jumlahTestimonial.value = res.data.length

    } catch (err) {
      console.error('Gagal ambil data dari database:', err)
    }
  }

 


    import 'vue3-carousel/carousel.css'
    import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'

    import { reactive} from 'vue';
    import TestimonialCard from './TestimonialCard.vue';


  const carouselConfig = {
    itemsToShow: 1,
    wrapAround: false, //sebelumnya true
    snapAlign: 'center',
    autoplay: 0,
    pauseAutoplayOnHover: true,
    transition: 600,
    mouseDrag: false, // Disable mouse drag to prevent shaking

  };

  const deleteInvalid = async () => {
  try {
    await axios.delete('http://localhost:8080/Testimonials/delete-invalid')
    await fetchTestimonials()
    console.log('Data null dihapus')
  } catch (err) {
    console.error('Gagal hapus data null:', err)
  }
}

  const deleteLast = async () => {
    try {
      await axios.delete('http://localhost:8080/Testimonials/delete-last')
      await fetchTestimonials()
      console.log('Data terakhir dihapus')
    } catch (err) {
      console.error('Gagal hapus data terakhir:', err)
    }
  }






</script>