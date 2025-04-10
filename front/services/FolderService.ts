import { $fetch } from 'ofetch'
export interface Folder {
    id: number,
    name: string
}

export class FolderService {
    // TODO : Bien config les fonctions par rapport au route
    static async createFolder (name:string, idParent:number, idUser:number) {
        try {
        // making an API request to create a user
        const response = await $fetch<Folder>('http://localhost:8080/api/folder/create', {
            method: 'POST',
            body: { name, idParent, idUser }
        })
        return { ...response, success: true }
        } catch (error:unknown) {
        return { ...error.response._data, success: false }
        }
    }
    static async getContentFolder (idFolder:number,idUser:number) {
        try {
        // making an API request to create a user
        const response = await $fetch<Folder>(`http://localhost:8080/api/folder/${idFolder}`, {
            method: 'POST',
            body: { idUser }
        })
        return { ...response, success: true }
        } catch (error:unknown) {
        return { ...error.response._data, success: false }
        }
    }
}