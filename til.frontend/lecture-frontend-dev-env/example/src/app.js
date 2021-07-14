import {sum} from "./math";
import "./style.css";
import controller from "./controller";

document.addEventListener("DOMContentLoaded", () => {
  controller.init(document.querySelector("#app"))
});

console.log(sum(1, 2));
console.log(process.env.NODE_ENV);
console.log(TWO);
console.log(TWO_STR);

const alert = (msg) => window.alert(msg);
new Promise();
