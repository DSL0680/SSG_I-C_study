import LoadingComponent from "../common/LoadingComponent.tsx";
import PageComponent from "../common/PageComponent.tsx";
import useTodoList from "../../hooks/useTodoList.ts";
import {ITodo} from "../../types/todo.ts";


function TodoListComponent() {

    const {loading, pageResponse, moveToRead} = useTodoList()

    const listLI = pageResponse.content.map((todo:ITodo) => {

        const {mno, title, writer, dueDate} = todo

        return (
            <li
                key={mno}
                onClick={() => moveToRead(mno)}
                className="cursor-pointer hover:bg-blue-100 transition duration-200 p-2 border-b border-gray-200"
            >
                <div className="flex flex-col">
                    <div className="text-gray-800 font-semibold text-md">{title}</div>
                    <div className="text-gray-600 text-sm">MNO: {mno}</div>
                    <div className="text-gray-600 text-sm">Writer: {writer}</div>
                    <div className="text-gray-600 text-sm">Due Date: {dueDate}</div>
                </div>
            </li>
        )

    })

    return (
        <div className="container mx-auto mt-8">
            {loading && <LoadingComponent/>}
            <h2 className="text-2xl font-bold mb-4">Todo List</h2>
            <ul className="bg-white shadow-md rounded-lg">
                {listLI.length > 0 ? (
                    listLI
                ) : (
                    <li className="p-4 text-center text-gray-600">No todos available.</li>
                )}
            </ul>
            <PageComponent pageResponse={pageResponse}/>
        </div>
    );
}

export default TodoListComponent;