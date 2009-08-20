function openThisWindow(theURL,winName,winOpenedArr,category)
{
  var features ;
  var winOpened;

  //To ensure tht incase no flag is passed yet, then include a ?, else use a &
  //Also dont append anything if the URL is blank !
  if (theURL != "")
  {
    if (theURL.indexOf('?') != -1)
      theURL = theURL + "&hdPopUpWindow=True" ;
    else
      theURL = theURL + "?hdPopUpWindow=True" ;
  }

  var left = window.screenLeft ;
  var top = window.screenTop ;

  if (category == '1a')
  {
    features = 'resizable=yes,width=560,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '1b')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=yes'
  }
  else if (category == '1c')  //for advanced analysis
  {
    features = 'resizable=yes,width=750,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2a')
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2b')
  {
    features = 'resizable=yes,width=400,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2c')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2d')
  {
    features = 'resizable=yes,width=400,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3a')  //For comment windows
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3b')
  {
    features = 'resizable=yes,width=400,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3c')
  {
    features = 'resizable=yes,width=500,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3d')
  {
    features = 'resizable=yes,width=600,height=500,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '4a')
  {
    features = 'resizable=yes,width=700,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }

  for (var i=0; i < winOpenedArr.length ; i++)
  {
    if (winOpenedArr[i] && winOpenedArr[i].open && !winOpenedArr[i].closed)
    {
      if (winOpenedArr[i].name == winName)
      {
        winOpenedArr[i].focus();
        return winOpenedArr[i]
      }
    }
  }
  closeTheseWindows(winOpenedArr)
  winOpened = window.open(theURL,winName,features);
  return winOpened ;
}

function openTheseWindow(theURL,winName,winOpenedArr,category,closeFlag)
{
  var features ;
  var winOpened;

  //To ensure tht incase no flag is passed yet, then include a ?, else use a &
  //Also dont append anything if the URL is blank !
  if (theURL != "")
  {
    if (theURL.indexOf('?') != -1)
      theURL = theURL + "&hdPopUpWindow=True" ;
    else
      theURL = theURL + "?hdPopUpWindow=True" ;
  }

  var left = window.screenLeft ;
  var top = window.screenTop ;

  if (category == '1a')
  {
    features = 'resizable=yes,width=560,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '1b')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=yes'
  }
  else if (category == '1c')  //for advanced analysis
  {
    features = 'resizable=yes,width=750,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2a')
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2b')
  {
    features = 'resizable=yes,width=400,height=400,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2c')
  {
    features = 'resizable=yes,width=550,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '2d')
  {
    features = 'resizable=yes,width=400,height=350,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3a')  //For comment windows
  {
    features = 'resizable=yes,width=300,height=300,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3b')
  {
    features = 'resizable=yes,width=400,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3c')
  {
    features = 'resizable=yes,width=500,height=450,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '3d')
  {
    features = 'resizable=yes,width=600,height=500,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }
  else if (category == '4a')
  {
    features = 'resizable=yes,width=700,height=550,screenX=0,screenY=0,top='+(top)+',left='+(left)+',toolbar=no,scrollbars=yes,status=no'
  }

  for (var i=0; i < winOpenedArr.length ; i++)
  {
    if (winOpenedArr[i] && winOpenedArr[i].open && !winOpenedArr[i].closed)
    {
      if (winOpenedArr[i].name == winName)
      {
        winOpenedArr[i].focus();
        return winOpenedArr[i]
      }
    }
  }
  if(closeFlag)
      closeTheseWindows(winOpenedArr);
  winOpened = window.open(theURL,winName,features);
  return winOpened ;
}

function closeTheseWindows(winOpenedArr)
{
  for (var i=0; i < winOpenedArr.length ; i++)
  {
    if (winOpenedArr[i] && winOpenedArr[i].open && !winOpenedArr[i].closed)
    {
      winOpenedArr[i].close();
    }
  }
}
