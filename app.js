// User Authentication Component
function AuthForm({ type, onSubmit }) {
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmit({ username, password });
    };

    return (
        <div className="auth-container">
            <h2>{type === 'login' ? 'Login' : 'Sign Up'}</h2>
            <form className="auth-form" onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Username:</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">{type === 'login' ? 'Login' : 'Sign Up'}</button>
            </form>
        </div>
    );
}

// Todo Item Component
function TodoItem({ todo, onComplete, onDelete, onEdit }) {
    return (
        <div className={`todo-item ${todo.completed ? 'completed' : ''}`}>
            <div>
                <h3>{todo.title}</h3>
                <p>{todo.description}</p>
            </div>
            <div className="todo-actions">
                <button onClick={() => onComplete(todo.id)}>
                    {todo.completed ? 'Undo' : 'Complete'}
                </button>
                <button onClick={() => onEdit(todo)}>Edit</button>
                <button onClick={() => onDelete(todo.id)}>Delete</button>
            </div>
        </div>
    );
}

// Todo List Component
function TodoList({ todos, onComplete, onDelete, onEdit }) {
    return (
        <div className="todos">
            <ul className="todo-list">
                {todos.map(todo => (
                    <li key={todo.id}>
                        <TodoItem
                            todo={todo}
                            onComplete={onComplete}
                            onDelete={onDelete}
                            onEdit={onEdit}
                        />
                    </li>
                ))}
            </ul>
        </div>
    );
}

// Category List Component
function CategoryList({ categories, selectedCategory, onSelectCategory }) {
    return (
        <div className="categories">
            <h3>Categories</h3>
            <ul className="category-list">
                {categories.map(category => (
                    <li
                        key={category}
                        className={`category-item ${selectedCategory === category ? 'active' : ''}`}
                        onClick={() => onSelectCategory(category)}
                    >
                        {category}
                    </li>
                ))}
            </ul>
        </div>
    );
}

// Main App Component
function App() {
    const [isLoggedIn, setIsLoggedIn] = React.useState(false);
    const [currentUser, setCurrentUser] = React.useState(null);
    const [users, setUsers] = React.useState({});
    const [todos, setTodos] = React.useState([]);
    const [selectedCategory, setSelectedCategory] = React.useState('Work');
    const [editingTodo, setEditingTodo] = React.useState(null);

    const categories = [
        'Work', 'Home', 'Grocery', 'Movies to Watch',
        'Places to Eat', 'Personal', 'Other'
    ];

    const handleAuth = (type, credentials) => {
        if (type === 'signup') {
            if (users[credentials.username]) {
                alert('Username already exists!');
                return;
            }
            setUsers(prev => ({
                ...prev,
                [credentials.username]: credentials.password
            }));
            alert('Sign up successful! Please login.');
        } else {
            if (users[credentials.username] === credentials.password) {
                setIsLoggedIn(true);
                setCurrentUser(credentials.username);
            } else {
                alert('Invalid username or password!');
            }
        }
    };

    const handleLogout = () => {
        setIsLoggedIn(false);
        setCurrentUser(null);
    };

    const handleAddTodo = (e) => {
        e.preventDefault();
        const title = e.target.title.value;
        const description = e.target.description.value;

        if (editingTodo) {
            setTodos(prev => prev.map(todo =>
                todo.id === editingTodo.id
                    ? { ...todo, title, description, category: selectedCategory }
                    : todo
            ));
            setEditingTodo(null);
        } else {
            setTodos(prev => [...prev, {
                id: Date.now(),
                title,
                description,
                category: selectedCategory,
                completed: false,
                username: currentUser
            }]);
        }
        e.target.reset();
    };

    const handleCompleteTodo = (id) => {
        setTodos(prev => prev.map(todo =>
            todo.id === id ? { ...todo, completed: !todo.completed } : todo
        ));
    };

    const handleDeleteTodo = (id) => {
        setTodos(prev => prev.filter(todo => todo.id !== id));
    };

    const handleEditTodo = (todo) => {
        setEditingTodo(todo);
    };

    const filteredTodos = todos.filter(todo =>
        todo.category === selectedCategory && todo.username === currentUser
    );

    if (!isLoggedIn) {
        return (
            <div className="container">
                <AuthForm type="login" onSubmit={(creds) => handleAuth('login', creds)} />
                <AuthForm type="signup" onSubmit={(creds) => handleAuth('signup', creds)} />
            </div>
        );
    }

    return (
        <div className="container">
            <div className="header">
                <h2>Welcome, {currentUser}!</h2>
                <button className="logout-btn" onClick={handleLogout}>Logout</button>
            </div>
            <div className="todo-container">
                <CategoryList
                    categories={categories}
                    selectedCategory={selectedCategory}
                    onSelectCategory={setSelectedCategory}
                />
                <div className="todos">
                    <form className="todo-form" onSubmit={handleAddTodo}>
                        <div className="form-group">
                            <input
                                type="text"
                                name="title"
                                placeholder="Todo title"
                                defaultValue={editingTodo?.title}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <input
                                type="text"
                                name="description"
                                placeholder="Todo description"
                                defaultValue={editingTodo?.description}
                                required
                            />
                        </div>
                        <button type="submit">
                            {editingTodo ? 'Update Todo' : 'Add Todo'}
                        </button>
                    </form>
                    <TodoList
                        todos={filteredTodos}
                        onComplete={handleCompleteTodo}
                        onDelete={handleDeleteTodo}
                        onEdit={handleEditTodo}
                    />
                </div>
            </div>
        </div>
    );
}

// Render the App
ReactDOM.render(<App />, document.getElementById('root')); 