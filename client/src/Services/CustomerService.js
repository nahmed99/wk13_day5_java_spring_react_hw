
// Added the following line to package.json (to overcome CORS problem for dev purposes):
//      "proxy": "http://localhost:8080/",
//
// Now you only need to mention /courses in your fetch instead of...
//
// const baseURL = `http://localhost:8080/courses/${ques}${course}${connection}${town}`;
//
// Actually didn't use the above method - used the other one, added a package on server
// side to allow various configurations for access.


export const getCustomers = (inCourse, inTown) => {

    let ques = "";
    let course = "";
    let ampersand = "";
    let town = "";
    
    if (inCourse.length > 0 && inTown.length > 0) {
        // Course and Town passed in...
        ques = "?";
        course = "course=" + inCourse;
        ampersand = "&";
        town = "town=" + inTown;

    } else if (inCourse.length) {

        // Only course passed in
        ques = "?";
        course = "course=" + inCourse;
    }
   
    const baseURL = `http://localhost:8080/customers/${ques}${course}${ampersand}${town}`;

    console.log(baseURL);

    return fetch(baseURL)
    .then(res => res.json())
    .then(data => data)

 }