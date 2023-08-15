//숫자를 hh:MM:ss:mm로 보여주는 함수 
/**
 * 밀리초로 된 시간을 hh:MM:ss:mm으로 된 문자열을 반환하는 함수
 * @param {number|string} time 시간으로 단위가 밀리초로 주어짐
 * @returns 시간을 hh:MM:ss:mm으로 된 문자열을 반환
 */
function calculateTime(time) {
	return `${fillZero(getHour(time), 2)
		}:${fillZero(getMinute(time), 2)
		}:${fillZero(getSecond(time), 2)
		}:${fillZero(getMilliSecond(time).toString().substring(0, 2), 2)
		}`;
}
//주어진 숫자가 size개수보다 적으면 0을 채우는 함수 
function fillZero(num, size) {
	return num.toString().padStart(size, '0');
}
/**
 * 주어진시간(ms)에서 밀리초에 해당하는 값을 리턴하는 함수
 * @param {number|string} time 시간으로 단위가 밀리세컨드로 주어짐
 * @returns 주어진 시간에서 밀리초에 해당하는 값을 리턴
 */function getMilliSecond(time) {
	return time % 1000;
}
/**
 * 주어진시간(ms)에서 초에 해당하는 값을 리턴하는 함수
 * @param {number|string} time 시간으로 단위가 밀리세컨드로 주어짐
 * @returns 주어진 시간에서 초에 해당하는 값을 리턴
 */
function getSecond(time) {
	//밀리초 부분을 없앰
	time = parseInt(time / 1000);
	return time % 60;
}
/**
 * 주어진시간(ms)에서 분에 해당하는 값을 리턴하는 함수
 * @param {number|string} time 시간으로 단위가 밀리세컨드로 주어짐
 * @returns 주어진 시간에서 분에 해당하는 값을 리턴
 */
function getMinute(time) {
	//초 부분을 없앰
	time = parseInt(time / 1000 / 60);
	return time % 60;
}
/**
 * 주어진시간(ms)에서 시(Hour)에 해당하는 값을 리턴하는 함수
 * @param {number|string} time 시간으로 단위가 밀리세컨드로 주어짐
 * @returns 주어진 시간에서 시(Hour)에 해당하는 값을 리턴
 */
function getHour(time) {
	//분 부분을 없앰
	time = parseInt(time / 1000 / 60 / 60);
	return time % 60;
}