from django.urls import path
from . import views

app_name = 'User'
urlpatterns =[
    path('user', views.UserView.as_view()),
    path('user?<str:user_id>', views.UserView.as_view())

]