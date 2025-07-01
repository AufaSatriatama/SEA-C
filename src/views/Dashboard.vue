<template>
    <div class="page">

        <div v-if="isLogin == true">
            

            <div class="centerColumn">
                <h2>My Subscription</h2>

                <div v-if="listSubscriptionThisUser.length === 0">No active subscriptions found.</div>

                <div v-else>
                    <div v-for="subscription in listSubscriptionThisUser" :key="subscription.id" class="subscription-item">
                        <p>{{ subscription.name }}</p>
                        <p>{{ subscription.phoneNumber }}</p>
                        <p>{{ subscription.planSelection }}</p>
                
                    </div>
                </div>


                <!--
                <div class="logged-in-message">Sudah Login</div>
                -->
            </div>
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
    import axios from 'axios';
    import { onMounted } from 'vue';

    import { isLogin, currentUser } from '../globalVariable';

    let listSubscription = [];
    let listSubscriptionThisUser = [];

   const fetchSubscription = async () => {
       if (!isLogin) return;

       listSubscription = []; // Clear previous subscriptions
       try {
           const response = await axios.get('http://localhost:8080/Subscriptions');
           listSubscription = response.data;
       } catch (error) {
           console.error('Error fetching subscriptions:', error);
       }
   };

   const checkUserSubscription = (subscription) => {
    console.log('Checking user subscription:', currentUser.value);
       if (!isLogin) return false;

       // Assuming the subscription has a userId or similar field to check against the logged-in user
        for (let i = 0; i < listSubscription.length; i++) {
            const sub = listSubscription[i];
            if (sub.name === currentUser.value.username) {
                listSubscriptionThisUser.push(sub);
            }
        }

       console.log('List Subscription This User:', listSubscriptionThisUser);
       return;
   };

   onMounted(() => {
    fetchSubscription()
    checkUserSubscription()
   });



   onMounted(() => {
    fetchSubscription()
    checkUserSubscription()
   })

   onMounted(fetchSubscription, checkUserSubscription);
</script>

<style scoped>

.subscription-item{
    background-color: #f9f9f9;
    border: 1px solid #eee;
    border-radius: 5px;
    padding: 1rem;
    margin-bottom: 1rem;
    width: 100%;
}

.logged-in-message {
    color: #333;
    font-size: 1.5rem;
    font-weight: bold;
}

.centerColumn {
    display: flex;
    width: 50vw;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    background-color: rgb(255, 255, 255);   
    padding: 1rem;
}

.centerRow {
    display: flex;
    width: 50vw;
    justify-content: center;
    align-items: center;
    flex-direction: row;
    background-color: rgb(255, 255, 255);
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