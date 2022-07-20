from django.urls import path
from . import views

app_name = 'User'
urlpatterns =[
    path('', views.UserView.as_view(), name='user_post'),
    # path('<str:user_Id>', views.UserView.as_view(), name='user_detail'),
    path('user', views.UserView.as_view(), name='user_detail')

]