import { defineNuxtPlugin,   } from "#imports";
import axios from "axios";

export default defineNuxtPlugin((nuxtApp) => {
  const config = useRuntimeConfig();

  const apiClient = axios.create({
    baseURL: config.public.API_EDKFET_ENDPOINT,
    headers: {
      "Content-Type": "application/json",
    },
  });

  // Intercepteur pour ajouter dynamiquement le token JWT
  apiClient.interceptors.request.use((request) => {
    const token = localStorage.getItem("token") || config.public.API_EDKFET_TOKEN;
    if (token) {
      request.headers.Authorization = `Bearer ${token}`;
    }
    return request;
  });

  nuxtApp.provide("api", apiClient);
});
