<script setup lang="ts">
// TODO : TS à mettre pour certains truc 
import * as v from 'valibot'
import { ref, reactive } from 'vue'
import Title from "@/components/Title.vue"
import { UserService } from "@/services/UserService"
import type { FormSubmitEvent, FormError } from '@nuxt/ui'
import { navigateTo } from 'nuxt/app'
const connectForm = ref()
let errors: FormError[] = []
const stateForm = reactive({
  email: '',
  password: '',
});
const RegistrationSchema = v.object({
  email: v.pipe(v.string(), v.email('Email invalide')),
  password: v.pipe(v.string(), v.minLength(8,'Il faut au moins 8 caractères')),
})
// TODO : garder ? regarder l'utilité de cela sur la doc de valibot
type Schema = v.InferOutput<typeof RegistrationSchema>
const loginUser = async (event: FormSubmitEvent<any>) => {
  //showLoader()
  const res = await UserService.loginUser(stateForm.email, stateForm.password)
  if (res.success && 'id' in res && 'username' in res) {
    //login({ id: res.id, username: res.username })
    //addNotification('Connexion réussie', 'success')
    navigateTo('/home')
  }
  else if('type' in res && 'message' in res)
  {
    if ( res.type === 'email' ) 
    {
        errors.push({ name: 'email', message: res.message });
    }
   else if( res.type === 'password' )
   {
        errors.push({ name: 'password', message: res.message });
   }
   if (connectForm.value) {
      connectForm.value.validate()
    }
}
  //hideLoader()
}
const validForm = (stateForm: any) : FormError[] => {
  return errors
}
</script>
<template>
  <div class="flex flex-1 justify-center items-center h-full">
    <UForm ref="connectForm" :schema="RegistrationSchema" :state="stateForm" :validate="validForm" @submit="loginUser" class="flex flex-col justify-center h-90 bg-slate-900 rounded-lg p-4 max-w-7xl">
        <Title content="Connexion"/>
        <!-- Champ email -->
        <UFormField name="email" class="mt-6" required>
          <UInput v-model="stateForm.email" placeholder="" size="xl" :ui="{ base: 'peer' }" class="w-full" highlight>
            <p class="pointer-events-none absolute left-0 -top-2.5 text-xs font-semibold px-1.5 transition-all 
            peer-focus:-top-2.5 peer-focus:text-(--ui-text-highlighted) peer-focus:text-xs peer-focus:font-semibold
            peer-placeholder-shown:text-sm peer-placeholder-shown:text-(--ui-text-dimmed) peer-placeholder-shown:top-1.5 peer-placeholder-shown:font-normal">
              <span class="inline-flex bg-(--ui-bg) px-1">Email</span>
            </p>
          </UInput>
        </UFormField>
        <!-- Champ mot de passe -->
        <UFormField name="password" class="mt-6" required>
          <UInput v-model="stateForm.password" type="password" placeholder="" size="xl" :ui="{ base: 'peer' }" class="w-full" highlight>
            <p class="pointer-events-none absolute left-0 -top-2.5 text-xs font-semibold px-1.5 transition-all 
            peer-focus:-top-2.5 peer-focus:text-(--ui-text-highlighted) peer-focus:text-xs peer-focus:font-semibold
            peer-placeholder-shown:text-sm peer-placeholder-shown:text-(--ui-text-dimmed) peer-placeholder-shown:top-1.5 peer-placeholder-shown:font-normal">
              <span class="inline-flex bg-(--ui-bg) px-1">Mot de passe</span>
          </p>
          </UInput>
        </UFormField>
        <!-- Lien vers la connexion -->
        <p class="text-center mt-4">
            Vous ne possèdez pas de compte ?
            <NuxtLink to="/registration" color='primary' class="color-primary hover:underline">
            S'inscrire
            </NuxtLink>
        </p>
        <div class="w-full flex justify-end">
          <!-- Bouton Se connecter -->
          <UButton icon="mdi-account" type="submit" class="mt-4">
            Se connecter
          </UButton>
        </div>
    </UForm>
  </div>
</template>