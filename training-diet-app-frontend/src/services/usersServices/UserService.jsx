;

async function getUserData() {
    const token = localStorage.getItem('jwtToken');
    console.log(token)
    return fetch("http://localhost:9800/normal-user/account-data", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        credentials: 'include',

    })


}




function getUserMaxes() {
    const token = localStorage.getItem('jwtToken');

    return fetch("http://localhost:9800/normal-user/user-maxes", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        credentials: 'include',

    })
}



async function updateUsersData(data) {
    const token = localStorage.getItem('jwtToken');

    return await fetch("http://localhost:9800/normal-user/update-data", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },body: JSON.stringify(data)
    }
    )
}


async function addUserMaxes(data) {
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGlib3VAbWFpbC5jb20iLCJpYXQiOjE3MDA5MTk5NTYsImV4cCI6MTcwMDkyMTM5Nn0.EfZ70Dmb54sXheO3vTQLl5ERoZJI2vn3gGmaLNO-Fsc'
    console.log(data)
    return await fetch("http://localhost:9800/normal-user/add-maxes", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        credentials: 'include', body: JSON.stringify(data)
    }
    )
}



const GetAllUsers = () => {
    const token = localStorage.getItem('jwtToken');

    return fetch(
        `http://localhost:9800/admin-user/get-users`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        credentials: 'include',
    }
    )
}

const DeleteUserById = (id) => {
    const token = localStorage.getItem('jwtToken');

    return fetch(`http://localhost:9800/admin-user/delete-user/${id}`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        credentials: 'include',
    });

}
const RegisterUser = (data) => {
    return fetch("http://localhost:9800/api/v1/auth/register", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data)
    }
    )
}
const LoginToUserPage = (login) => {
    return fetch("http://localhost:9800/api/v1/auth/authenticate", {
        method: 'Post',

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(login)
    }
    )
}


export { addUserMaxes, getUserData, updateUsersData, getUserMaxes, GetAllUsers, DeleteUserById, RegisterUser, LoginToUserPage }