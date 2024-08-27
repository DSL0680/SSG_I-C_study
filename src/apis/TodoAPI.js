import axios from "axios"

const host = 'http://49.174.76.109:8080/api/v1/todos'
// const host = 'http://localhost:8088/api/v1/todos'

export const getList = async (page) => {

    const res = await axios.get(`${host}/list`, {
        params: { page: page, size: 100 }
    })

    return res.data

}

export const getOne = async (mno) => {
    const res = await axios.get(`${host}/${mno}`)

    return res.data
}

export const postOne = async (obj) => {

    const res = await axios.post(`${host}`, obj)

    return res.data
}

export const deleteOne = async (mno) => {

    const res = await axios.delete(`${host}/${mno}`)

    return res.data
}

export const putOne = async (todo) => {

    const res = await axios.put(`${host}/${todo.mno}`, todo)
    return res.data
}

export const getMypost = async (mid) => {

    const res = await axios.get(`${host}/${mid}`)

    return res.data

}