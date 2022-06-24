from django.urls import path
from . import views

app_name = 'User'
urlpatterns =[
    path('user/','<str:user_Id>', views.UserView.as_view(), name='user_get'),

]