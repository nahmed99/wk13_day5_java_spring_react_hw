export const getCourses = (inCustomer, inRating) => {

    let ques = "";
    let filter = "";
        
    if (inCustomer.length > 0) {
        // Use customer as the parameter
        ques = "?";
        filter = "customer=" + inCustomer;
    } else if (inRating.length > 0) {
        // Use customer as the parameter
        ques = "?";
        filter = "rating=" + inRating;
    }

    const baseURL = `http://localhost:8080/courses/${ques}${filter}`;

    console.log(baseURL);

    return fetch(baseURL)
    .then(res => res.json())

 }


//  return fetch(baseURL, {
//     headers : { 
//       'Content-Type': 'application/json',
//       'Accept': 'application/json'
//      }

//   })
// .then(res => res.json())