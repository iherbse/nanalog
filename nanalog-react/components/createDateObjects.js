import { range, takeWhile, last } from 'lodash';
import moment from 'moment';

export default function createDateObjects(date, weekOffset = 0,pageList) {
  const startOfMonth = date.startOf('month');
  let pageId = null;
  if(pageList!==null){
  for(var i = 0; i< pageList.length;i++){
    const pageDate = pageList[i].date;
    if(pageDate === date.format('YYYYMMdd')){
      pageId = pageList[i].pid;
    }
  }
}


  let diff = startOfMonth.weekday() - weekOffset;
  if (diff < 0) diff += 7;

  const prevMonthDays = range(0, diff).map(n => ({
    day: startOfMonth.clone().subtract(diff - n, 'days'),
    classNames: 'prevMonth'
  }));

  const currentMonthDays = range(1, date.daysInMonth() + 1).map(index => ({
    day: moment([date.year(), date.month(), index]),
    padeId : pageId
  }));

  const daysAdded = prevMonthDays.length + currentMonthDays.length - 1;
  const nextMonthDays = takeWhile(range(1, 7), n => (daysAdded + n) % 7 !== 0).map((n) => ({
    day: last(currentMonthDays).day.clone().add(n, 'days'),
    classNames: 'nextMonth'
  }));

  return [...prevMonthDays, ...currentMonthDays, ...nextMonthDays];
}
