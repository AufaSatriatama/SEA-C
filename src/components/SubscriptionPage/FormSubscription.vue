<template class="centerColumn">

    <form @submit.prevent="validateForm">
        <div>
            <input id="name" v-model="form.name" type="text" placeholder="Nama"/>
            <span v-if="errors.name">{{ errors.name }}</span>            
        </div>

        <div>
            <input id="number" v-model="form.number" type="number" placeholder="Nomor"/>
            <span v-if="errors.number">{{ errors.number }}</span>
        </div>

        <div>Plan Selection</div>
        
        <div>
            <label>
                <input type="radio" :value="1" v-model="opsiJenis"  /> Diet Plan (30K per Meal)
            </label>
        
            <label>
                <input type="radio" :value="2" v-model="opsiJenis"  /> Protein Plan (40K per Meal)
            </label>

            <label>
                <input type="radio" :value="3" v-model="opsiJenis"  /> Royal Plan (60K per Meal)
            </label>
        </div>

        <div>Meal Type</div>

        <div>
            <label>
                <input type="checkbox" :value="1" v-model="opsiMakan"  /> Breakfast
            </label>

            <label>
                <input type="checkbox" :value="2" v-model="opsiMakan"  /> Lunch
            </label>

            <label>
                <input type="checkbox" :value="3" v-model="opsiMakan"  /> Dinner
            </label>
        </div>

        <div>Delivery Days</div>

        <div>
            <label>
                <input type="checkbox" :value="1" v-model="deliveryDay"  /> Monday
            </label>

            <label>
                <input type="checkbox" :value="2" v-model="deliveryDay"  /> Tuesday
            </label>
            
            <label>
                <input type="checkbox" :value="3" v-model="deliveryDay"  /> Wednesday
            </label>

            <label>
                <input type="checkbox" :value="4" v-model="deliveryDay"  /> Thursday
            </label>

            <label>
                <input type="checkbox" :value="5" v-model="deliveryDay"  /> Friday
            </label>

            <label>
                <input type="checkbox" :value="6" v-model="deliveryDay"  /> Saturday
            </label>

            <label>
                <input type="checkbox" :value="7" v-model="deliveryDay"  /> Sunday
            </label>

        </div>

        <textarea v-model="alergi" name="alergi" placeholder="Daftar alergi Anda"></textarea>

        <button type="submit">Submit</button>
    </form>

    <div>Total Harga: </div>

    <div>{{ totalHarga }}</div>

</template>

<style scoped>

.centerRow{
    display: flex;
    width: 50vw;
    justify-content: center;
    align-items: center;
    flex-direction: row;
}

.centerColumn{
    display: flex;
    width: 50vw;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

.inputNormal {
color: black;
  width: 100%;
  height: 50px;
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 10px;
  box-sizing: border-box;
}

</style>

<script setup>
import { computed, ref } from 'vue';
import axios from 'axios';
import { reactive } from 'vue'
import * as yup from 'yup'

//
const opsiJenis = ref(null);
const opsiMakan = ref([]);
const deliveryDay = ref([]);
const alergi = ref('');

let totalHarga = ref(0);

totalHarga = computed(() => {

    let hargaTotal = 0;
    let hargaPerMeal = 0;
    let jumlahMakan = 0;
    let jumlahHari = deliveryDay.value.length;

    if (opsiJenis.value === 1) {
        hargaPerMeal = 30000;
    } else if (opsiJenis.value === 2) {
        hargaPerMeal = 40000;
    } else if (opsiJenis.value === 3) {
        hargaPerMeal = 60000;
    }

    if (opsiMakan.value) {
        jumlahMakan = opsiMakan.value.length;
    }

    if (jumlahMakan > 0 && jumlahHari > 0) {
        hargaTotal = hargaPerMeal * jumlahMakan * jumlahHari * 4.3;
    }

    return hargaTotal;
});

const form = reactive({
  name: '',
  number: '',
})

const errors = reactive({
  name: '',
  password: '',
})

const schema = yup.object({
  name: yup.string()
    .required('Nama wajib diisi'),
  number: yup.string()
    .required('Nomor wajib diisi')
    .length(10, 'Nomor harus 10 digit'),
    

})

const validateForm = async () => {
  try {
    await schema.validate(form, { abortEarly: false })
    alert('Data valid!')

    try{
        const response = await axios.post('http://localhost:8080/Subscriptions', {
            name: form.name,
            phoneNumber: form.number,
            planSelection: opsiJenis.value,
            mealType: opsiMakan.value,
            deliveryDays: deliveryDay.value,
            pesan : alergi.value



        }, {withCredentials: true});
        console.log('Subscription successful:', response.data);

            //clear form
            form.name = '';
            form.number = '';
            opsiJenis.value = null;
            opsiMakan.value = [];
            deliveryDay.value = [];
            alergi.value = '';

    } catch (error) {
        console.error('name', form.name);
        console.error('number', form.number);
        console.error('opsiJenis', opsiJenis.value);
        console.error('opsiMakan', opsiMakan.value);
        console.error('deliveryDay', deliveryDay.value);
        console.error('alergi', form.alergi);
        console.error('Error submitting subscription:', error);
    }

  } catch (err) {
    // Reset error
    errors.name = ''
    errors.password = ''
    console.log("errors", err);

    err.inner.forEach(e => {
      errors[e.path] = e.message
    })
  }
}

</script>