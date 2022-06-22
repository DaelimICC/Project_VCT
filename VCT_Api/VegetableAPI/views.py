from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import UserSerializer
from rest_framework import status
from .models import User
from rest_framework import generics


class UserView(generics.RetrieveUpdateDestroyAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer

# class UserView(APIView):
#     def post(self, request):
#         user_serializer = UserSerializer(data=request.data)
#         if user_serializer.is_valid():
#             user_serializer.save()
#             return Response(user_serializer.data, status=status.HTTP_201_CREATED)
#         else:
#             return Response(user_serializer.errors, status=status.HTTP_400_BAD_REQUEST)
#
#     def get_object(self, pk):
#         try:
#             return User.objects.get(pk=pk)
#         except User.DoesNotExist:
#             return Response("Invaild Request", status=status.HTTP_400_BAD_REQUEST)
#
#     def get(self, request, pk=None, format=None):
#         if pk:
#             data = self.get_object(pk)
#         else:
#             data = User.objects.all()
#
#         user_serializer = UserSerializer(data, many=True)
#         return Response(user_serializer.data)

    # def get(self, request, pk):
    #     user_queryset = self.get_object(pk)
    #     user_serializer = UserSerializer(user_queryset)
    #     return Response(user_serializer.data)
    #
    # def post(self, request):
    #     user_serializer = UserSerializer(data=request.data)
    #     if user_serializer.is_valid():
    #         user_serializer.save()
    #         return Response(user_serializer.data, status=status.HTTP_201_CREATED)
    #     else:
    #         return Response(user_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # def get(self, request, **kwargs):
    #     if kwargs.get('user_Id') is None:
    #         user_queryset = User.objects.all()
    #         user_queryset_serializer = UserSerializer(user_queryset, many=True)
    #         return Response(user_queryset_serializer.data, status=status.HTTP_200_OK)
    #     else:
    #         user_id = kwargs.get('user_Id')
    #         user_serializer = UserSerializer(User.objects.get(user_Id=user_id))
    #         return Response(user_serializer.data, status=status.HTTP_200_OK)

    # def put(self, request, **kwargs):
    #     if kwargs.get('user_Id') is None:
    #         return Response("Invaild Request", status=status.HTTP_400_BAD_REQUEST)
    #     else:
    #         user_id = kwargs.get('user_Id')
    #         user_object = User.objects.get(user_Id=user_id)
    #
    #         update_seriralizer = UserSerializer(user_object, data=request.data)
    #         if update_seriralizer.is_valid():
    #             update_seriralizer.save()
    #             return Response(update_seriralizer.data, status=status.HTTP_200_OK)
    #         else:
    #             return Response("Invaild Request", status=status.HTTP_400_BAD_REQUEST)
    #
    # def delete(self, request, **kwargs):
    #     if kwargs.get('user_Id') is None:
    #         return Response("Invaild Error", status=status.HTTP_400_BAD_REQUEST)
    #     else:
    #         user_id = kwargs.get('user_Id')
    #         user_object = User.objects.get(user_Id=user_id)
    #         user_object.delete()
    #         return Response("Delete", status=status.HTTP_200_OK)

