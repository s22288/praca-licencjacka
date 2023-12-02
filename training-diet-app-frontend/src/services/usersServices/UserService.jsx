import { redirect } from 'react-router';


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
const authenticate = () => {
    console.log('authenticate')
    const token = localStorage.getItem('jwtToken');
    const role = JSON.parse(window.atob(token.split(".")[1])).role;
    let userRole = role[0].authority
    if (!token?.access_token) throw redirect('/login')
    return { access_token: token, username: 'name' };

}




async function getUserMaxes() {
    const token = localStorage.getItem('jwtToken');

    return await fetch("http://localhost:9800/normal-user/user-maxes", {
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
    console.log('data' + data)
    return await fetch("http://localhost:9800/normal-user/update-data", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }, body: JSON.stringify(data)
    }
    )
}



async function addUserMaxes(data) {
    const token = localStorage.getItem('jwtToken');
    return await fetch("http://localhost:9800/normal-user/add-maxes", {
        method: 'Post',
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
// /update-premium
// const BuyPremiumSubscription = () => {
//     const token = localStorage.getItem('jwtToken');

//     return fetch("http://localhost:9800/normal-user/update-premium", {
//         method: 'Post',
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json',
//             'Authorization': `Bearer ${token}`,

//         },
//         credentials: 'include',
//     }
//     )
// }
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




export { addUserMaxes, getUserData, updateUsersData, getUserMaxes, GetAllUsers, DeleteUserById, RegisterUser, LoginToUserPage, authenticate }