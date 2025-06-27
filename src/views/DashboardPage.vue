<template>
    <div class="page">

        <div v-if="isLogin == true">
            <div class="logged-in-message">Sudah Login</div>
        </div>

        <div v-else>
            <div class="centerRow">
                <router-link to="/RegisterPage">
                    <button>Register</button>
                </router-link>

                <router-link to="/LoginPage">
                    <button>Login</button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script setup>
    import { ref } from 'vue';

    import { isLogin } from '../globalVariable';

   
</script>

<style scoped>

.logged-in-message {
    color: green;
    font-size: 1.5rem;
    font-weight: bold;
}

.centerRow {
    display: flex;
    width: 50vw;
    justify-content: center;
    align-items: center;
    flex-direction: row;
    background-color: rebeccapurple;
    gap: 1rem;
}

.page{
  
  background-color: rgb(255, 255, 255);
  width: 100%; /* w-screen */

  min-height: 100vh; /* h-screen */
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  gap: 2rem; /* space-y-8 */
 
  
}
</style>