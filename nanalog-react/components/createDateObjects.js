import { range, takeWhile, last } from 'lodash';
import moment from 'moment';

// npm의 package인데 custom해야 될 부분들이 있어서 가져온 function
// createDateObjects = 이번달 달력에 들어갈 date들을 계산하고 return해주는 function

export default function createDateObjects(date, weekOffset = 0,pageList) {
  const startOfMonth = date.startOf('month');
  let pageId = null;


  let diff = startOfMonth.weekday() - weekOffset;
  if (diff < 0) diff += 7;

// 예를 들어서 이번 달 1일이 수요일부터 시작된다면 전 달의 마지막 주 월,화의 date들을 구함. (전 달이라도 달력에 표시하기 위함)
  const prevMonthDays = range(0, diff).map(n => ({
    day: startOfMonth.clone().subtract(diff - n, 'days'),
    classNames: 'prevMonth',
    pageId : getPageId(pageList,moment([date.year(), date.month()-1, startOfMonth.clone().subtract(diff - n, 'days')]))
  }));
// 이번달 date들을 구함.
  const currentMonthDays = range(1, date.daysInMonth() + 1).map(index => ({
    day: moment([date.year(), date.month(), index]),
    pageId : getPageId(pageList,moment([date.year(), date.month(), index]))
  }));

  const daysAdded = prevMonthDays.length + currentMonthDays.length - 1;

  // 예를 들어서 이번 달 마지막 일이 수요일부터 끝난다면 다음 달의 첫 주 목,금,토,일 의 date들을 구함. (다음 달이라도 달력에 표시하기 위함)
  const nextMonthDays = takeWhile(range(1, 7), n => (daysAdded + n) % 7 !== 0).map((n) => ({
    day: last(currentMonthDays).day.clone().add(n, 'days'),
    classNames: 'nextMonth',
    pageId : getPageId(pageList,moment([date.year(), date.month()+1, last(currentMonthDays).day.clone().add(n, 'days')]))
  }));

// 앞에서 구한 date들을 순서대로 return.
  return [...prevMonthDays, ...currentMonthDays, ...nextMonthDays];
}
// pageList = fetchPreviewPage를 통해 가져온 이번 달 preview page list.
// getPageId는 pageList의 date와 현재 date를 비교해서 date가 같다면 pageId를 return, 아니라면 return null
// 그날에 diary를 썼는지 표시(노란배경), click시 그 page를 볼 때 pageId가 필요.
function getPageId(pageList,date){
  let pageId = null;
  if(pageList){
  for(var i = 0; i< pageList.length;i++){
    const pageDate = pageList[i].date;
    if(pageDate == date.format('YYYYMMDD')){
      pageId = pageList[i].pid;
      return pageId;
    }
  }
  return null;
  }
}
