<script setup lang="ts">
// TODO : Gérer le message d'erreur quand l'adresse mail est déjà utilisée, ainsi que le user
// TODO : TS à mettre pour certains truc 
import * as v from 'valibot'
import { ref ,computed, reactive } from 'vue'
import Title from "@/components/Title.vue"
import type { FormError } from '@nuxt/ui'
import { UserService } from "@/services/UserService"
import { navigateTo } from 'nuxt/app'

const registrationForm = ref()
let errors: FormError[] = []
let response;
const stateForm = reactive({
  email: '',
  username: '',
  password: '',
  confirmPassword: ''
});
// Create login schema with email and password
const RegistrationSchema = v.object({
  email: v.pipe(v.string(), v.email('Email invalide')),
  username: v.pipe(v.string()),
  password: v.pipe(v.string(), v.minLength(8,'Il faut au moins 8 caractères')),
  confirmPassword: v.pipe(v.string(), v.minLength(8,'Il faut au moins 8 caractères'))
})
// TODO : garder ? regarder l'utilité de cela sur la doc de valibot
type Schema = v.InferOutput<typeof RegistrationSchema>

const validForm = async (stateForm: any): Promise<FormError[]> => {
  // TODO : Faire l'appel seulement si user ou email qui a changé
  // TODO : createUser ce serait dans l'écouteur et un autre pour faire les vérifs ? 
  // TODO : Genre utiliser getUser() à la place ? 
  //response = await UserService.createUser(stateForm.email, stateForm.password)
  if(stateForm.password !== stateForm.confirmPassword) 
  {
    errors.push({ name: 'confirmPassword', message: 'Les mots de passe ne correspondent pas' })
  }
  else if('type' in response && 'message' in response)
  {
    if ( response.type === 'email' ) 
    {
      errors.push({ name: 'email', message: response.message });
    }
  }
  return errors
}
  
// Activer le bouton seulement si les champs sont remplis
const isButtonActive = computed(() => 
  stateForm.email && stateForm.password 
  && stateForm.confirmPassword && stateForm.password === stateForm.confirmPassword
);

const createUser = async () => {
  // POST fetch to create new
  // loader()
  const response = await UserService.createUser(stateForm.email, stateForm.username,stateForm.password)
  // hideLoader()
  if (response.success) {
    // Redirect to login page
    navigateTo('/login')
  }
}
</script>
<template>
  <div class="flex flex-1 justify-center items-center h-full">
    <UForm ref="registrationForm" :schema="RegistrationSchema" :validate="validForm" :state="stateForm" class="flex flex-col justify-center bg-slate-900 rounded-lg p-4 max-w-7xl h-120">
        <Title content="Inscription"/>
        <!-- Champ email -->
        <UFormField name="email" class="mt-6" required>
          <!-- TO DO : Mettre le input dans un composant comme on utilise tjrs le même -->
          <UInput v-model="stateForm.email" placeholder="" size="xl" :ui="{ base: 'peer' }" class="w-full" highlight>
            <p class="pointer-events-none absolute left-0 -top-2.5 text-xs font-semibold px-1.5 transition-all 
            peer-focus:-top-2.5 peer-focus:text-(--ui-text-highlighted) peer-focus:text-xs peer-focus:font-semibold
            peer-placeholder-shown:text-sm peer-placeholder-shown:text-(--ui-text-dimmed) peer-placeholder-shown:top-1.5 peer-placeholder-shown:font-normal">
              <span class="inline-flex bg-(--ui-bg) px-1">Email</span>
            </p>
          </UInput>
        </UFormField>
        <!-- Champ username -->
        <UFormField name="username" class="mt-6" required>
          <UInput v-model="stateForm.username" placeholder="" size="xl" :ui="{ base: 'peer' }" class="w-full" highlight>
            <p class="pointer-events-none absolute left-0 -top-2.5 text-xs font-semibold px-1.5 transition-all 
            peer-focus:-top-2.5 peer-focus:text-(--ui-text-highlighted) peer-focus:text-xs peer-focus:font-semibold
            peer-placeholder-shown:text-sm peer-placeholder-shown:text-(--ui-text-dimmed) peer-placeholder-shown:top-1.5 peer-placeholder-shown:font-normal">
              <span class="inline-flex bg-(--ui-bg) px-1">Nom d'utilisateur</span>
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
        <!-- Champ confirmation du mot de passe -->
        <UFormField name="confirmPassword" class="mt-6" required>
          <UInput v-model="stateForm.confirmPassword" type="password" placeholder="" size="xl" :ui="{ base: 'peer' }" class="w-full" highlight>
            <p class="pointer-events-none absolute left-0 -top-2.5 text-xs font-semibold px-1.5 transition-all 
            peer-focus:-top-2.5 peer-focus:text-(--ui-text-highlighted) peer-focus:text-xs peer-focus:font-semibold
            peer-placeholder-shown:text-sm peer-placeholder-shown:text-(--ui-text-dimmed) peer-placeholder-shown:top-1.5 peer-placeholder-shown:font-normal">
              <span class="inline-flex bg-(--ui-bg) px-1">Confirmation du mot de passe</span>
          </p>
          </UInput>
        </UFormField>
        <!-- Lien vers la connexion -->
        <p class="text-center mt-4">
            Vous possédez déjà un compte ?
            <NuxtLink to="/login" color='primary' class="color-primary hover:underline">
            Se connecter
            </NuxtLink>
        </p>
        <!-- Bouton S'inscrire -->
        <div class="w-full flex justify-end">
          <UButton icon="i-heroicons-user-plus" :disabled="!isButtonActive" @click="createUser" class="mt-4">
            S'inscrire
          </UButton>
        </div>
    </UForm>
  </div>
</template>