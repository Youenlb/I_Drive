<script setup lang="ts">
// TODO : Gérer le message d'erreur quand l'adresse mail est déjà utilisée
// TODO : TS à mettre pour certains truc 
import * as v from 'valibot'
import { ref } from 'vue'
import Title from "@/components/Title.vue"
import {computed, reactive } from 'vue'
import type { FormError } from '@nuxt/ui'
import { UserService } from "@/services/UserService"

const emailErrorMessage = ref('')
const emailOfTheLastError = ref()

const stateForm = reactive({
  email: '',
  password: '',
  confirmPassword: ''
});
// Create login schema with email and password
const RegistrationSchema = v.object({
  email: v.pipe(v.string(), v.email('Email invalide')),
  password: v.pipe(v.string(), v.minLength(8,'Il faut au moins 8 caractères')),
  confirmPassword: v.pipe(v.string(), v.minLength(8,'Il faut au moins 8 caractères'))
})
// TODO : garder ? regarder l'utilité de cela sur la doc de valibot
type Schema = v.InferOutput<typeof RegistrationSchema>

const validForm = (stateForm: any): FormError[] => {
  const errors = []
  if(stateForm.password !== stateForm.confirmPassword) 
  {
    errors.push({ name: 'confirmPassword', message: 'Les mots de passe ne correspondent pas' })
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
  //showLoader()
  //TODO : .value à mettre ou pas besoin sans ref ? 
  const response = await UserService.createUser(stateForm.email, stateForm.password)
  //hideLoader()
  if (response.success) {
    // Redirect to login page
    //navigateTo('/login')
  } else {
    // Add user error message in userErrorMessage variable
    // To manage rules on the username field
    emailErrorMessage.value = response.message
    emailOfTheLastError.value = stateForm.email
    // Validate form to check field rules
    //form.value.validate()
  }
}
</script>
<template>
  <div class="flex flex-1 justify-center items-center h-full">
    <UForm :schema="RegistrationSchema" :validate="validForm" :state="stateForm" class="bg-white rounded-lg p-4 w-9/12">
        <Title content="Inscription"/>
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
        <UButton icon="i-heroicons-user-plus" :disabled="!isButtonActive" @click="createUser">
            S'inscrire
        </UButton>
    </UForm>
  </div>
</template>