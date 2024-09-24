import {useNavigate, useParams, useSearchParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {ITodo} from "../../types/todo.ts";
import {getOne} from "../../api/todoAPI.ts";
import LoadingComponent from "../common/LoadingComponent.tsx";

const initialState:ITodo = {
    mno: 0,
    title:'',
    writer:'',
    dueDate:''
}

function TodoReadComponent() {

    const {mno} = useParams()
    const navigate = useNavigate();
    const [query] = useSearchParams();

    const [todo, setTodo] = useState(initialState)
    const [loading, setLoading] = useState(false)

    useEffect(()=>{
        const mnoNum = Number(mno)
        setLoading(true)
        getOne(mnoNum).then(result => {
            setTodo(result)
            setLoading(false)
        })

    },[mno])

    const page:number = Number(query.get("page")) || 1;
    const size:number = Number(query.get("size")) || 10;

    const goBackToList = () => {
        navigate(`/todo/list?page=${page}&size=${size}`);
    };

    return (
        <div className="container mx-auto mt-8">
            {loading && <LoadingComponent/>}
            <div className="bg-white shadow-md rounded-lg p-6">
                <h4 className="text-2xl font-bold mb-4">Todo Read Component</h4>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-700">MNO:</label>
                    <div className="text-lg text-blue-600">{mno}</div>
                </div>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-700">Title:</label>
                    <div className="text-lg text-blue-600">{todo.title}</div>
                </div>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-700">Writer:</label>
                    <div className="text-lg text-blue-600">{todo.writer}</div>
                </div>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-700">Due Date:</label>
                    <div className="text-lg text-blue-600">{todo.dueDate}</div>
                </div>
                <div className="text-center">
                    <button
                        className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 transition"
                        onClick={goBackToList}
                    >
                        뒤로가기
                    </button>
                </div>
            </div>
        </div>
    );
}

export default TodoReadComponent;