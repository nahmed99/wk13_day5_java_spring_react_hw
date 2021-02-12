// The following variables will be used to populate the baseURL variable - these assume that course nor twon are passed in...
let ques = "";
let course = "";
let connection = "";
let town = "";

const baseURL = `http://localhost:8080/courses/${ques}${course}${connection}${town}/`;


export const getCourse = (inCourse, inTown) => {

    if (inCourse.length > 0 && inTown.length > 0) {
        // Course and Town passed in...
        ques = "?";
        course = inCourse;
        connection = "&";
        town = inTown;

    } else if (inCourse.length) {
        
        // Only course passed in
        ques = "?";
        course = inCourse;
    }

    return fetch(baseURL)
    .then(res => res.json())
}