from django.shortcuts import render
from requests import Response
from serializer import CustomerSerializer
from models import Customer
from rest_framework.decorators import api_view
from drf_yasg import openapi
from drf_yasg.utils import swagger_auto_schema

@swagger_auto_schema(
    methods=['post'],
    request_body=openapi.Schema(
        type=openapi.TYPE_OBJECT,
        required=['first_name','last_name','account_no', 'email', 'password','phone','created_at'],
        properties={
            'account_no': openapi.Schema(type=openapi.TYPE_NUMBER),
            'first_name': openapi.Schema(type=openapi.TYPE_STRING),
            'last_name': openapi.Schema(type=openapi.TYPE_STRING),
            'phone': openapi.Schema(type=openapi.TYPE_STRING),
            'email': openapi.Schema(type=openapi.TYPE_STRING),
            'password': openapi.Schema(type=openapi.TYPE_STRING),
            'created_at': openapi.Schema(type=openapi.TYPE_STRING, format=openapi.FORMAT_DATETIME),
        },
    ),
    operation_description='Create Customer',
    responses={200: ""}
)

@api_view(['GET', 'POST'])
# Create your views here.
def customer_list(request):
   if request.method == 'GET':
       customers = Customer.objects.all()
       serializer = CustomerSerializer(customers, many=True)
       return Response(serializer.data)
   elif request.method == 'POST':
       serializer = CustomerSerializer(data=request.data)
       if serializer.is_valid():
           serializer.save()
           return Response(serializer.data, status=201)
       return Response(serializer.errors, status=400)
