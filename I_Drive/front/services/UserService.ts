export interface User {
    id: number,
    email: string,
    password: string,
    isAdmin: boolean,
    isSuspended: boolean
}

export class UserService {
  static async getUsers () {
    try {
      const res = await $fetch<User[]>('/api/user/getAll')
      return res
    } catch (e) {
      console.error(e)
      return []
    }
  }

  static async getUser (id:number) {
    try {
      const res = await $fetch<User>(`/api/user/get/${id}`)
      return res
    } catch (e) {
      console.error(e)
      return null
    }
  }

  static async createUser (email:string, password:string) {
    try {
      // making an API request to create a user
      const response = await $fetch<User>('/api/user/create', {
        method: 'POST',
        body: { email, password }
      })
      return { ...response, success: true }
    } catch (error:unknown) {
      // User already exists
      return { ...error.response._data, success: false }
    }
  }

  static async loginUser (email:string, password:string) {
    try {
      // making an API request to login a user
      const response = await $fetch<User>('/api/user/login', {
        method: 'POST',
        body: { email, password }
      })
      return { ...response, success: true }
    } catch (error:unknown) {
      if (error instanceof Error && 'response' in error) {
        const err = error as { response: { _data: {type: string, message: string} } }
        return { ...err.response._data, success: false }
      }
      console.error(error)
      return { success: false }
    }
  }

  static async updateUser (id:number, email:string, password:string, isAdmin:boolean, isSuspended:boolean) {
    try {
      // making an API request to login a user
      const response = await $fetch<User>(`/api/user/update/${id}`, {
        method: 'PUT',
        body: { email, password, isAdmin, isSuspended }
      })
      return { ...response, success: true }
    } catch (error:unknown) {
      if (error instanceof Error && 'response' in error) {
        const err = error as { response: { _data: {type: string, message: string} } }
        return { ...err.response._data, success: false }
      }
      console.error(error)
      return { success: false }
    }
  }

  static async deleteUser (id:number) {
    try {
      // making an API request to login a user
      const response = await $fetch<User>(`/api/user/delete/${id}`, {
        method: 'DELETE'
      })
      return { ...response, success: true }
    } catch (error:unknown) {
      if (error instanceof Error && 'response' in error) {
        const err = error as { response: { _data: {type: string, message: string} } }
        return { ...err.response._data, success: false }
      }
      console.error(error)
      return { success: false }
    }
  }
}