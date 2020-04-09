package com.example.fibonacci_clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class fibonacci_widget extends AppWidgetProvider {




    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {

            ComponentName thisWidget = new ComponentName(context,
                    fibonacci_widget.class);
            int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
            for (int widgetId : allWidgetIds) {
                // create some random data

                RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                        R.layout.fibonacci_widget);

                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.fibonacci_widget);
                //views.setImageViewResource(R.id.Value5, Color.BLUE);
                Date currentTime = Calendar.getInstance().getTime();
                int hour = currentTime.getHours();
                int minute = currentTime.getMinutes();
                int constant[] = {5, 3, 2, 1, 1};
                int hours[] = {0, 0, 0, 0, 0};
                int minutes[] = {0, 0, 0, 0, 0};
                double random = Math.random() * 1000;
                int start = (int) random;
                hour = hour % 12;
                start = start % 32;
                int sum = 0;
                while (true) {
                    hours[0] = 0;
                    hours[1] = 0;
                    hours[2] = 0;
                    hours[3] = 0;
                    hours[4] = 0;
                    sum = 0;

                    int c = 4;
                    for (int i = start; i > 0; i = i / 2) {
                        int temp = i % 2;
                        if (temp == 1) {
                            hours[c] = 1;
                            sum = sum + temp * constant[c];
                        }
                        c--;
                    }
                    if (sum == hour)
                        break;
                    start++;
                    start = start % 32;
                }
                //Toast.makeText(this, hour+" "+" "+hours[0]+" "+hours[1]+" "+hours[2]+" "+hours[3]+" "+hours[4], Toast.LENGTH_SHORT).show();

                double random2 = Math.random() * 1000;
                int start2 = (int) random2;
                start2 = start2 % 32;
                minute = minute / 5;
                int sum2 = 0;
                while (true) {
                    minutes[0] = 0;
                    minutes[1] = 0;
                    minutes[2] = 0;
                    minutes[3] = 0;
                    minutes[4] = 0;
                    sum2 = 0;

                    int c = 4;
                    for (int i = start2; i > 0; i = i / 2) {
                        int temp = i % 2;
                        if (temp == 1) {
                            minutes[c] = 1;
                            sum2 = sum2 + temp * constant[c];
                        }
                        c--;
                    }
                    if (sum2 == minute)
                        break;
                    start2++;
                    start2 = start2 % 32;
                }
                //Toast.makeText(this, minute+" "+" "+minutes[0]+" "+minutes[1]+" "+minutes[2]+" "+minutes[3]+" "+minutes[4], Toast.LENGTH_SHORT).show();

                for (int i = 0; i < 5; i++) {

                    int c = 0;
                    switch (i) {
                        case 0:
                            c = R.id.Value5;
                            break;

                        case 1:
                            c = R.id.Value3;
                            break;

                        case 2:
                            c = R.id.Value2;
                            break;
                        case 3:
                            c = R.id.Value1a;
                            break;
                        case 4:
                            c = R.id.Value1b;
                            break;

                    }
                    if (hours[i] + minutes[i] == 2)
                        views.setImageViewResource(c, R.color.common);
                    else if (hours[i] == 0 && minutes[i] == 1)
                        views.setImageViewResource(c, R.color.minutes);
                    else if (hours[i] == 1 && minutes[i] == 0)
                        views.setImageViewResource(c, R.color.hours);
                    else
                        views.setImageViewResource(c, R.color.none);
                }

                final AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                final Intent i = new Intent(context, fibonacci_widget.class);

                i.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetIds);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(context,
                        0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                manager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 60001, pendingIntent2);
                appWidgetManager.updateAppWidget(appWidgetId, views);


                Intent intent = new Intent(context, fibonacci_widget.class);

                intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                remoteViews.setOnClickPendingIntent(R.id.relativeLayout, pendingIntent);
                appWidgetManager.updateAppWidget(widgetId, remoteViews);

            }
        }
    }

    @Override
    public void onEnabled(Context context) {
        final RemoteViews views =new RemoteViews(context.getPackageName(),R.layout.fibonacci_widget);
        //views.setImageViewResource(R.id.Value5, Color.BLUE);

        // Date time = Calendar.getInstance().getTime();

                Date currentTime= Calendar.getInstance().getTime();
                int hour= currentTime.getHours();
                int minute=currentTime.getMinutes();
                int constant[]={5,3,2,1,1};
                int hours[]={0,0,0,0,0};
                int minutes[]={0,0,0,0,0};
                double random=Math.random()*1000;
                int start=(int)random;
                hour=hour%12;
                start=start%32;
                int sum=0;
                while(true)
                {   hours[0]=0;
                    hours[1]=0;
                    hours[2]=0;
                    hours[3]=0;
                    hours[4]=0;
                    sum=0;

                    int c=4;
                    for(int i=start;i>0;i=i/2)
                    {
                        int temp=i%2;
                        if(temp==1) {
                            hours[c]=1;
                            sum = sum + temp * constant[c];
                        }
                        c--;
                    }
                    if(sum==hour)
                        break;
                    start++;
                    start=start%32;
                }
                //Toast.makeText(this, hour+" "+" "+hours[0]+" "+hours[1]+" "+hours[2]+" "+hours[3]+" "+hours[4], Toast.LENGTH_SHORT).show();

                double random2=Math.random()*1000;
                int start2=(int)random2;
                start2=start2%32;
                minute=minute/5;
                int sum2=0;
                while(true)
                {   minutes[0]=0;
                    minutes[1]=0;
                    minutes[2]=0;
                    minutes[3]=0;
                    minutes[4]=0;
                    sum2=0;

                    int c=4;
                    for(int i=start2;i>0;i=i/2)
                    {
                        int temp=i%2;
                        if(temp==1) {
                            minutes[c]=1;
                            sum2 = sum2 + temp * constant[c];
                        }
                        c--;
                    }
                    if(sum2==minute)
                        break;
                    start2++;
                    start2=start2%32;
                }
                //Toast.makeText(this, minute+" "+" "+minutes[0]+" "+minutes[1]+" "+minutes[2]+" "+minutes[3]+" "+minutes[4], Toast.LENGTH_SHORT).show();

                for(int i=0;i<5;i++) {

                    int c=0;
                    switch (i)
                    {
                        case 0:
                            c=R.id.Value5;
                            break;

                        case 1:
                            c=R.id.Value3;
                            break;

                        case 2:
                            c=R.id.Value2;
                            break;
                        case 3:
                            c=R.id.Value1a;
                            break;
                        case 4:
                            c=R.id.Value1b;
                            break;

                    }
                    if (hours[i] + minutes[i] == 2)
                        views.setImageViewResource(c, R.color.common);
                    else if (hours[i]==0&&minutes[i] == 1)
                        views.setImageViewResource(c, R.color.minutes);
                    else if (hours[i]==1&&minutes[i] == 0)
                        views.setImageViewResource(c, R.color.hours);
                    else
                        views.setImageViewResource(c, R.color.none);
                }



            }


}





