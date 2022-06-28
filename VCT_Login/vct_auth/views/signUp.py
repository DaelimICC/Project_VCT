from django.http import JsonResponse
from rest_framework import status
from rest_framework.views import APIView
from vct_auth.serializer import SignupUserSerializer


class SignUpView(APIView):

    def post(self, request):
        serializer = SignupUserSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()

            res = {
                'success': True
            }
            return JsonResponse(res, status=status.HTTP_201_CREATED)

        else:
            res = {
                'success': False,
                'err': serializer.errors
            }
            return JsonResponse(res, status=status.HTTP_400_BAD_REQUEST)
