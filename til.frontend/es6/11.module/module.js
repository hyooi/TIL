import {getTime, getCurrentHour, MyLogger} from './myLogger.js';
import _ from './utility.js'

const root = document.querySelector("#root");
root.innerHTML = "<p>Hello World!</p>";

_.log("my first test data");
_.log(`time: ${getTime()}`);
_.log(`current hour: ${getCurrentHour()}`);

const logger = new MyLogger();
_.log(`lectures : ${logger.getLectures()}`);