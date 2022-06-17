from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import UserSerializer
from rest_framework import status
from .models import User


class UserView(APIView):
    def post(self, request):

        user_serializer = UserSerializer(data=request.data)
        if user_serializer.is_valid():
            user_serializer.save()
            return Response(user_serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response("Invaild Error", status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, **kwargs):
        if kwargs.get('user_Id') is None:
            return Response("Invaild Error", status=status.HTTP_400_BAD_REQUEST)
        else:
            user_id = kwargs.get('user_Id')
            user_serializer = UserSerializer(User.objects.get(user_Id=user_id))
            return Response(user_serializer.data, status.HTTP_200_OK)

    def put(self, request, **kwargs):
        if kwargs.get('user_Id') is None:
            return Response("Invaild Request", status=status.HTTP_400_BAD_REQUEST)
        else:
            user_id = kwargs.get('user_Id')
            user_object = User.objects.get(user_Id=user_id)

            update_seriralizer = UserSerializer(user_object, data=request.data)
            if update_seriralizer.is_valid():
                update_seriralizer.save()
                return Response(update_seriralizer.data, status=status.HTTP_200_OK)
            else:
                return Response("Invaild Request", status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, **kwargs):
        if kwargs.get('user_Id') is None:
            return Response("Invaild Error", status=status.HTTP_400_BAD_REQUEST)
        else:
            user_id = kwargs.get('user_Id')
            user_object = User.objects.get(user_Id=user_id)
            user_object.delete()
            return Response("Delete", status=status.HTTP_200_OK)

